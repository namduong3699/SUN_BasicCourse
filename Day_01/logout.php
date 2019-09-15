<?php
session_start();

require "Token.php";
$token = new Token();

$_SESSION["user_id"] = "";
session_destroy();

$token->clearAuthCookie();

header("Location: ./");
?>