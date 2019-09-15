<?php 
session_start();

require_once "validate.php";

if(!$loggedIn) {
    header("Location: ./");
}
?>
<style>

</style>
<div>
    Logged in!<a href="logout.php">Logout</a>
</div>