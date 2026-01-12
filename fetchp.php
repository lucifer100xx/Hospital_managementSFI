<?php
include '../config/db.php';

$sql = "SELECT * FROM patients ORDER BY created_at DESC";
$result = $conn->query($sql);

$patients = [];
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $patients[] = $row;
    }
}

echo json_encode($patients);
$conn->close();
?>
