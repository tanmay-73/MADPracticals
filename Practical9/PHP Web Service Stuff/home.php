<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "android";
$conn = new mysqli($servername, $username, $password, $database);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$heroes = array(); 
$sql = "SELECT id, name FROM heroes;";
$stmt = $conn->prepare($sql);
$stmt->execute();
$stmt->bind_result($id, $name);
while($stmt->fetch()){
 $temp = [
 'id'=>$id,
 'name'=>$name
 ];
 array_push($heroes, $temp);
}
echo json_encode($heroes);