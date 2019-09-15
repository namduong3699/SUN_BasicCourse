<?php
session_start();
require_once "Auth.php";
require_once "Token.php";

$auth = new Auth();
$db = new DBController();
$token = new Token();

require_once "validate.php";

if($loggedIn) {
	$token->redirect("welcome.php");
}

if(!empty($_POST["login"])) {
	$isAuthenticated = false;
	$username = $_POST["username"];
	$password = $_POST["password"];

	$user = $auth->getUserByUsername($username);
	if (password_verify($password, $user[0]["password"])) {
		$isAuthenticated = true;
	}

	if ($isAuthenticated) {
		$_SESSION["user_id"] = $user[0]["id"];

        // Set Cookies nếu chọn 'Remember Me'
		if (!empty($_POST["remember"])) {
			setcookie("username", $username, $cookie_expiry);

			$random_pass = $token->getToken(16);
			setcookie("randomPass", $random_pass, $cookie_expiry);

			$random_token = $token->getToken(32);
			setcookie("randomToken", $random_token, $cookie_expiry);

			$random_pass_hash = password_hash($random_pass, PASSWORD_DEFAULT);
			$random_token_hash = password_hash($random_token, PASSWORD_DEFAULT);

			$expiry_date = date("Y-m-d H:i:s", $cookie_expiry);

            // Đánh dấu token hết hạn
			$userToken = $auth->getTokenByUsername($username, 0);
			if (!empty($userToken[0]["id"])) {
				$auth->markExpired($userToken[0]["id"]);
			}
            // Thêm mới token
			$auth->insertToken($username, $random_pass_hash, $random_token_hash, $expiry_date);
		} else {
			$token->clearAuthCookie();
		}
		$token->redirect("welcome.php");
	} else {
		$message = "Invalid Login";
	}
}
?>

<style>
    * {
        margin: 0;
        padding: 0;
    }
    body {
        background: #eee;
    }
    .login{
        background: #1dd1a1;
        width: 20%;
        padding: 20px;
        margin: 30px auto;
    }
    .login>h2 {
        font-size: 32px;
        text-align: center;
    }
    .lgForm>div {
        margin: 0 auto;
        display: block;
    }
    input {
        width: 100%;
        margin: 0 auto;
        height: 2rem;
    }
    .lgbtn {
        width: 20%;
        margin: 0 auto;
        display: block;
    }
    #remember {
        height: 1rem;
        width: 10%;
        margin: 5px;

    }
</style>

<div class="login">
    <h2>LOGIN</h2>
    <form action="" method="post" class="lgForm">
        <div><?php if(isset($message)) { echo $message; } ?></div>
        <div>
            <div>
                <label for="login">Username</label>
            </div>
            <div>
                <input name="username" type="text"
                value="<?php if(isset($_COOKIE["username"])) { echo $_COOKIE["username"]; } ?>"
                >
            </div>
        </div>
        <div>
            <div>
                <label for="password">Password</label>
            </div>
            <div>
                <input name="password" type="password"
                value="<?php if(isset($_COOKIE["password"])) { echo $_COOKIE["password"]; } ?>"
                >
            </div>
        </div>
        <div class="rememberMe">
            <div>
                <input type="checkbox" name="remember" id="remember"
                <?php if(isset($_COOKIE["username"])) { ?> checked
                <?php } ?> /> <label for="remember-me">Remember me</label>
            </div>
        </div>
        <div>
            <div>
                <input type="submit" name="login" value="Login" class="lgbtn"></span>
            </div>
        </div>
    </form>
</div>