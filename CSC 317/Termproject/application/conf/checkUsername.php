 // Include database connection

    include_once "dbConfig.php";

    // Check username is already exists in database

    $username = $_POST['username'];
    $email = $_POST['email'];
    
    $query = "SELECT * FROM users WHERE username = '$username' || email = '$email'";
    
    $result = $con->query($query);
    
    if ($result->num_rows > 0) {
        echo 1;
    }else{
      $query = "INSERT INTO users ('name,email,username,age,city_name') 
                VALUES('john cena',$username','$email',35,'colifornia')";
      $result = $con->query($query);
      echo 0;
    }