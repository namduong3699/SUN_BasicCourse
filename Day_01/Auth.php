<?php
require "DBController.php";
class Auth {
	function getUserByUsername($username) {
		$db = new DBController();
		$query = "Select * from users where username = ?";
		$result = $db->runQuery($query, 's', array($username));
		return $result;
	}

	function getTokenByUsername($username, $expired) {
		$db = new DBController();
		$query = "Select * from token_auth where username = ? and is_expired = ?";
		$result = $db->runQuery($query, 'si', array($username, $expired));
	    return $result;
	}

	function markExpired($tokenId) {
		$db = new DBController();
		$query = "UPDATE token_auth SET is_expired = ? WHERE id = ?";
		$expired = 1;
		$result = $db->update($query, 'ii', array($expired, $tokenId));
		return $result;
	}

	function insertToken($username, $randomPassHash, $randomToken, $expiry_date) {
        $db = new DBController();
        $query = "INSERT INTO token_auth (username, password_hash, random_hash, expiry_date) values (?, ?, ?,?)";
        $result = $db->insert($query, 'ssss', array($username, $randomPassHash, $randomToken, $expiry_date));
        return $result;
    }

	function update($query) {
        mysqli_query($this->conn,$query);
    }
}
?>