<?php

use Firebase\Auth\Token\Exception\InvalidToken;


session_start();
include('dbcon.php');
if(isset($_POST['login_btn']))
{
    $email = $_POST['email'];
    $clearTextPassword = $_POST['password'];
    try {
        $user = $auth->getUserByEmail("$email");
        try{
            $signInResult = $auth->signInWithEmailAndPassword($email, $clearTextPassword);
            $idTokenString = $signInResult->idToken();
            
            try {
                $verifiedIdToken = $auth->verifyIdToken($idTokenString);
                $uid = $verifiedIdToken->claims()->get('sub');
                $user = $auth->getUser($uid);
                $verifiedIdToken = $auth->verifyIdToken($idTokenString);
            
                $_SESSION['verified_user_id'] = $uid;
                $_SESSION['idTokenString'] = $idTokenString;

                $_SESSION = "Logged in successfully";
                header('Location:home.php');
                exit();

            } catch (InvalidToken $e) {
                echo 'The token is invalid: ' . $e->getMessage();
            } catch (\InvalidArgumentException $e) {
                echo 'The token could not be parsed: ' . $e->getMessage();
            }

        }
        catch(Exception $e)
        {
            $_SESSION = "Wrong password";
            header('Location:login.php');
            exit();
        }
    } catch (\Kreait\Firebase\Exception\Auth\UserNotFound $e) {
        echo $e->getMessage();
        $_SESSION = "Invalid email address";
        header('Location:login.php');
        exit();
    }
}
else{
    $_SESSION = "Not allowed";
    header('Location:login.php');
    exit();
}
?>