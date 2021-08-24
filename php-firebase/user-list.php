<?php
include('authentication.php');
include('includes/header.php');
?>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <?php
            if (isset($_SESSION['status'])) {
                echo "<h5 class = 'alert alert-success'>" . $_SESSION['status'] . "</h5>";
                unset($_SESSION['status']);
            }
            ?>
            <div class="card">
                <div class="card-header">
                    <h4>
                        Registered user list
                    </h4>
                </div>
                <div class="card-body">
                    <table class="table table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>User No</th>
                                <th>Display</th>
                                <th>Phone Number</th>
                                <th>Email ID</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            include('dbcon.php');
                            $users = $auth->listUsers();
                            $i = 1;
                            foreach ($users as $user) {
                                /** @var \Kreait\Firebase\Auth\UserRecord $user */
                                // ...
                            ?>
                                <tr>
                                    <td><?= $i++; ?></td>
                                    <td><?= $user->displayName ?></td>
                                    <td><?= $user->phoneNumber ?></td>
                                    <td><?= $user->email ?></td>
                                    <td>
                                        <a href="user-edit.php?id=<?= $user->uid; ?>" class="btn btn-primary btn-sm">Edit</a>
                                    </td>
                                    <td>
                                        <!--<a href="user-delete.php" class="btn btn-danger btn-sm">Delete</a>-->
                                        <form action="code.php" method="POST">
                                            <button type="submit" name="reg_user_delete_btn" value="<?= $user->uid; ?>" class="btn btn-danger btn-sm">Delete</button>
                                        </form>
                                    </td>
                                </tr>
                            <?php


                            }
                            ?>
                        </tbody>

                </div>
            </div>
        </div>
    </div>
</div>

<?php
include('includes/footer.php');
?>