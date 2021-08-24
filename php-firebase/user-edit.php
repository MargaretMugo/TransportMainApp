<?php
include('authentication.php');
include('includes/header.php');
?>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <?php
            if (isset($_SESSION['status'])) {
                echo "<h5 class = 'alert alert-success'>" . $_SESSION['status'] . "</h5>";
                unset($_SESSION['status']);
            }
            ?>
            <div class="card">
                <div class="card-header">
                    <h4>
                        Edit and update users
                        <a href="index.php" class="btn btn-primary float-end">Back</a>
                    </h4>
                </div>
                <div class="card-body">
                    <form action="code.php" method="POST">
                        <?php
                        include('dbcon.php');
                        if (isset($_GET['id'])) {
                            try {
                                $user = $auth->getUser($uid);
                        ?>
                                <input type="hidden" name = "user_id"value = "<?=$uid;?>">
                                <div class="form-group mb-3">
                                    <label for="">Display Name</label>
                                    <input type="text" name="display_name" value="<?= $user->displayName; ?>" class="form-control">
                                </div>

                                <div class="form-group mb-3">
                                    <label for="">Phone Number</label>
                                    <input type="text" name="phone" value="<?= $user->phoneNumber; ?>" class="form-control">
                                </div>
                                <div class="form-group mb-3">
                                    <button type="submit" name="update_user_btn" class="btn btn-primary">Update</button>
                                </div>
                        <?php
                            } catch (\Kreait\Firebase\Exception\Auth\UserNotFound $e) {
                                echo $e->getMessage();
                            }
                        }

                        ?>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<?php
include('includes/footer.php');
?>