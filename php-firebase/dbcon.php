<?php

require __DIR__ . '/vendor/autoload.php';

use Kreait\Firebase\Factory;

$factory = (new Factory)
    ->withServiceAccount('transportmainapp-firebase-adminsdk-6u3cb-777e2a9115.json')
    ->withDatabaseUri('https://transportmainapp-default-rtdb.firebaseio.com/');
$database = $factory->createDatabase();
?>