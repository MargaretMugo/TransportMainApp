<?php
session_start();

unset($_SESSION['verified_user_id']);
unset($_SESSION['idTokenString']);
if($_SESSION['verified_admin'])
{
    unset($_SESSION['verified_admin']);
    $_SESSION['status'] = "Logged out successfully";
}
elseif($_SESSION['verified_super_admin']){
    unset($_SESSION['verified_admin']);
    $_SESSION['status'] = "Logged out successfully";
}
if(isset($_SESSION['expiry_status']))
{
    $_SESSION['status'] = "Session expired";
}
else
{
    $_SESSION['status'] = "Logged out successfully";
}

header('Location:login.php');
exit();
?>
