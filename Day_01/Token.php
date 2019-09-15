<?php
class Token {
	public function getToken($length) {
		$characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		$charactersLength = strlen($characters);
		$token = '';
		for ($i = 0; $i < $length; $i++) {
			$token .= $characters[rand(0, $charactersLength - 1)];
		}
		return $token;
	}

	function clearAuthCookie() {
		if(isset($_COOKIE["username"])) {
			setcookie("username", "");
		}
		if(isset($_COOKIE["randomPass"])) {
			setcookie("randomPass", "");
		}
		if(isset($_COOKIE["randomToken"])) {
			setcookie("randomToken", "");
		}
	}

	public function redirect($url) {
        header("Location:" . $url);
        exit;
    }
}
?>