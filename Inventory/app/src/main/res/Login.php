<?php
    $con = mysqli_connect("localhost", "id157835_echostar", "123456", "id157835_credentials");
    if (mysqli_connect_errno())
    {
       echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }
    $username = $_POST["username"];
    $password = $_POST["password"];
  
    $statement = mysqli_prepare($con, "SELECT * FROM credentials WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $username, $password, $role);

    $response = array();
    $response["success"] = false;
    $response["con"] = $con;
    $response["statement"] = $statement;
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["username"] = $username;
        $response["password"] = $password;
        $response["role"] = $role;
    }

    echo json_encode($response);
    mysqli_close($con);
?>