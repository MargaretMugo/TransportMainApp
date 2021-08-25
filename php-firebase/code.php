<?php
session_start();
include('dbcon.php');

if(isset($_POST['user_claims_btn']))
{
    $uid = $_POST['claims_user_id'];
    $roles = $_POST['role_as'];

    if($roles == 'admin')
    {
        $auth->setCustomUserClaims($uid, ['admin']);
        $msg = "User role as Admin";
    }elseif($roles == 'super_admin')
    {
        $auth->setCustomUserClaims($uid, ['super_admin']);
        $msg = "User role as Super Admin";
    }elseif($roles =='norole')
    {
        $auth->setCustomUserClaims($uid, null);
        $msg = "User has been removed!";
    }
    if ($msg) {
        $_SESSION['status'] = $msg;
        header('Location:user-list.php?id=$uid');
        exit();
    } else {
        $_SESSION['status'] = "Password not updated!";
        header('Location:user-list.php?id=$uid');
        exit();
    }
}





if(isset($_POST['change_password_btn']))
{
    $new_password = $_POST['new_password'];
    $retype_password = $_POST['retype_password'];
    $uid = $_POST['change_pwd_user_id'];
    if($new_password == $retype_password)
    {
        $updatedUser = $auth->changeUserPassword($uid,$new_password);
        if ($updatedUser) {
            $_SESSION['status'] = "Password updated!";
            header('Location:user-list.php');
            exit();
        } else {
            $_SESSION['status'] = "Password not updated!";
            header('Location:user-list.php');
            exit();
        }
    }
    else
    {
        $_SESSION['status'] = "Passwords do not match";
        header('Location:user-list.php?id=$uid');
        exit();
    }
    
}

if(isset($_POST['enable_disable_user_ac']))
{
    $disable_enable = $_POST['select_enable_disable'];
    $uid = $_POST['ena_dis_user_id'];
    if($disable_enable == "disable")
    {
        
        $updatedUser = $auth->disableUser($uid);
        $msg = "Account disabled";
    }
    else{
        $updatedUser = $auth->enableUser($uid);
        $msg = "Account enabled";
    }

    if ($updatedUser) {
        $_SESSION['status'] = $msg;
        header('Location:user-list.php');
        exit();
    } else {
        $_SESSION['status'] = "Something went wrong!";
        header('Location:user-list.php');
        exit();
    }
}

if(isset($_POST['reg_user_delete_btn']))
{   
    $uid = $_POST['reg_user_delete_btn'];
    try
    {
        $auth->deleteUser($uid);
        $_SESSION['status'] = "User deleted Successfully";
        header('Location:user-list.php');
        exit();
    }
    catch(Exception $e)
    {
        $_SESSION['status'] = "No User ID Found";
        header('Location:user-list.php');
        exit();
    }
    
}

if (isset($_POST['update_user_btn']))
{
    $displayname = $_POST['display_name'];
    $phone = $_POST['phone'];

    $uid = $_POST['user_id'];
    $properties = [
        'displayName' => $displayname,
        'phoneNumber' => $phone
    ];

    $updatedUser = $auth->updateUser($uid, $properties);

    if($updatedUser)
    {
        $_SESSION['status'] = "User updated Successfully";
        header('Location:user-list.php');
        exit();
    }else{
        $_SESSION['status'] = "User not updated!";
        header('Location:user-list.php');
        exit();
    }
}




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