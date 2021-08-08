<?php
session_start();
include('dbcon.php');

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
    $age = $_POST['age'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];

    $updateData = [
        'fullName' => $fullName,
        'age' => $age,
        'email' => $email,
        'phone' => $phone,
    ];
    $ref_table = 'Users/'.$key;
    $updatequery_result = $database->getReference()->update($updateData);
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
    $age = $_POST['age'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];

    $postData = [
        'fullName'=>$fullName,
        'age' => $age,
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