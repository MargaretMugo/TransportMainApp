<?php

require __DIR__ . '/vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\Auth;
use Kreait\Firebase\Exception\FirebaseException;

$factory = (new Factory)
    ->withServiceAccount('transportmainapp-firebase-adminsdk-6u3cb-18d82ebb61.json')
    ->withDatabaseUri('https://transportmainapp-default-rtdb.firebaseio.com/');
$database = $factory->createDatabase();
$auth = $factory->createAuth();

/*try {
    // The operation you want to perform
    echo 'OK';
} catch (FirebaseException $e) {
    echo 'An error has occurred while working with the SDK: '.$e->getMessage;
} catch (Throwable $e) {
    echo 'A not-Firebase specific error has occurred: '.$e->getMessage;
}

*/


?>