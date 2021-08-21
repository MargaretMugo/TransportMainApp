<?php
session_start();
include('dbcon.php');

if(isset($_POST['register_btn']))
{
    $fullName = $_POST['fullName'];
    $email = $_POST['email'];
    $phoneNo = $_POST['phone'];
    $password = $_POST['password'];

    $userProperties = [
        'email' =>  $email,
        'emailVerified' => false,
        'phone' => '+254'.$phoneNo,
        'password' => $password,
        'displayName' => $fullName,
        'photoUrl' => 'http://www.example.com/12345678/photo.png',
        'disabled' => false,
    ];

    //$createdUser = $auth->createUser($userProperties);
    try {
        $createdUser = $auth->createUser($userProperties);
    } catch (\Throwable $e) {
        echo $e->getMessage();
        exit;
    }
    if($createdUser)
    {
        $_SESSION['status'] = "User Created Successfully";
        header('Location:register.php');
        exit();
    }
    else{
        $_SESSION['status'] = "User Not Created";
        header('Location:register.php');
        exit();
    }
}

if(isset($_POST['disable_btn']))
{
    $del_id = $_POST['disable_btn'];
    $ref_table = 'Users/'.$del_id;
    $deletequery_result = $database->getReference('Users')->remove();
    if ($deletequery_result) {
        $_SESSION['status'] = "User disabled successfully";
        header('Location:index.php');
    } else {
        $_SESSION['status'] = "User not disabled";
        header('Location:index.php');
    }
}

if(isset($_POST['update_user']))
{
    $key = $_POST['key'];
    $fullName = $_POST['fullName'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];

    $updateData = [
        'fullName' => $fullName,
        'email' => $email,
        'phone' => $phone,
    ];
    $ref_table = 'Users/'.$key;
    $updatequery_result = $database->getReference($ref_table)->update($updateData);
    if ($updatequery_result) {
        $_SESSION['status'] = "User updated successfully";
        header('Location:index.php');
    } else {
        $_SESSION['status'] = "User not updated";
        header('Location:index.php');
    }

}


if(isset($_POST['save_user']))
{
    $fullName = $_POST['fullName'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];

    $postData = [
        'fullName'=>$fullName,
        'email' => $email,
        'phone' => $phone,
    ];
    $ref_table = "Users";
$postRef_result = $database->getReference($ref_table)->push($postData);
if($postRef_result)
{
    $_SESSION['status'] = "User Added successfully";
    header('Location:index.php');

}
else
{
        $_SESSION['status'] = "User not Added";
        header('Location:index.php');

}


}
?>