<?php
class DBController {
	private $host = "localhost";
	private $user = "root";
	private $password = "";
	private $database = "bt";
	// private $conn = mysqli_connect($this->host, $this->user, $this->password, $this->database);
	private $conn;

	function __construct() {
        $this->conn = $this->connectDB();
	}	
	
	function connectDB() {
		$conn = mysqli_connect($this->host,$this->user,$this->password,$this->database);
		return $conn;
	}

	//1 tham số
	function runBaseQuery($query) {
		$result = mysqli_query($this->conn, $query);
		while($row = mysqli_fetch_assoc($result)) {
			$resultArr[] = $row;
		}
		if(!empty($resultArr)) {
			return $resultArr;
		}
	}

	function bindQueryParams($sql, $param_type, $param_value_array) {
        $param_value_reference[] = & $param_type;
        for($i = 0; $i < count($param_value_array); $i++) {
            $param_value_reference[] = & $param_value_array[$i];
        }
        call_user_func_array(array(
            $sql,
            'bind_param'
        ), $param_value_reference);
    }

	//Nhiều tham số
	function runQuery($query, $param_type, $param_value_array) {
        $sql = $this->conn->prepare($query);
        $this->bindQueryParams($sql, $param_type, $param_value_array);
        $sql->execute();
        $result = $sql->get_result();
        
        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                $resultArr[] = $row;
            }
        }
        
        if(!empty($resultArr)) {
            return $resultArr;
        }
    }

	function insert($query, $param_type, $param_value_array) {
        $sql = $this->conn->prepare($query);
        $this->bindQueryParams($sql, $param_type, $param_value_array);
        $sql->execute();
    }

	function update($query, $param_type, $param_value_array) {
		$sql = $this->conn->prepare($query);
		$this->bindQueryParams($sql, $param_type, $param_value_array);
		$sql->execute();
	}
}
?>