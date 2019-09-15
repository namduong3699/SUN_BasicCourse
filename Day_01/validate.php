<?php
require_once "Auth.php";
require_once "Token.php";

$auth = new Auth();
$db = new DBController();
$token = new Token();

$current_time = time();
$current_date = date("Y-m-d H:i:s", $current_time);

$cookie_expiry = $current_time + (60 * 60 * 24 * 30); //1 tháng
$loggedIn = false;

if(!empty($_SECCTION["user_id"])) {
	// $loggedIn = true;
}
else if(!empty($_COOKIE["username"]) && !empty($_COOKIE["randomPass"]) && ! empty($_COOKIE["randomToken"])) {
	$passwordVerified = false;
    $tokenVerified = false;
    $expiryVerified = false;

    $userToken = $auth->getTokenByUsername($_COOKIE["username"], 0);
    if (password_verify($_COOKIE["randomPass"], $userToken[0]["password_hash"])) {
        $passwordVerified = true;
    }

    if (password_verify($_COOKIE["randomToken"], $userToken[0]["random_hash"])) {
        $tokenVerified = true;
    }

    if($userToken[0]["expiry_date"] >= $current_date) {
        $expiryVerified = true;
    }

    if (!empty($userToken[0]["id"]) && $passwordVerified && $tokenVerified && $expiryVerified) {
        $loggedIn = true;
    } else {
        if(!empty($userToken[0]["id"])) {
            $auth->markExpired($userToken[0]["id"]);
        }
        $token->clearAuthCookie();
    }
}
?>