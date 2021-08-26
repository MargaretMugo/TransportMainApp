<?php

use Firebase\Auth\Token\Exception\InvalidToken;

session_start();
include('dbcon.php');
if(isset($_SESSION['verified_user_id']))
{
    if(isset($_SESSION['verified_admin'])){

    
        $uid = $_SESSION['verified_user_id'];
        $idTokenString = $_SESSION['idTokenString'];

        try {
            $verifiedIdToken = $auth->verifyIdToken($idTokenString);
            //echo "Working"
        } catch (InvalidToken $e) {
            echo 'The token is invalid: ' . $e->getMessage();
            $_SESSION['expiry_status'] = "Token Expired. Log in again";
            header('Location:logout.php');
            exit();
        } catch (\InvalidArgumentException $e) {
            echo 'The token could not be parsed: ' . $e->getMessage();
            $_SESSION['expiry_status'] = "Token Expired. Log in again";
            header('Location:logout.php');
            exit();
        }
    }else{
        $_SESSION['status'] = "Access denied! because you are not an admin";
        header("Location:{$_SERVER["HTTP_REFERER"]}");
        exit();
    }
}
else
{
    $_SESSION['status'] = "Log in to access this page";
    header('Location:login.php');
    exit();
}
