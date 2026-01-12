<?php
include '../config/db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $patient_id = $_POST['patient_id'];
    $appointment_date = $_POST['appointment_date'];
    $appointment_time = $_POST['appointment_time'];
    $doctor_name = $_POST['doctor_name'];
    $reason = $_POST['reason'];
    
    $sql = "INSERT INTO appointments (patient_id, appointment_date, appointment_time, doctor_name, reason) VALUES (?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("idsss", $patient_id, $appointment_date, $appointment_time, $doctor_name, $reason);
    
    if ($stmt->execute()) {
        echo json_encode(['success' => true, 'message' => 'Appointment scheduled successfully']);
    } else {
        echo json_encode(['success' => false, 'message' => 'Error: ' . $conn->error]);
    }
    
    $stmt->close();
}

$conn->close();
?>
