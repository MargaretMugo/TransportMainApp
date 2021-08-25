<?php

use Kreait\Firebase\Value\Uid;

include('authentication.php');
include('dbcon.php');
include('includes/header.php');
?>

<div class="container">
    <?php
    if (isset($_SESSION['status'])) {
        echo "<h5 class = 'alert alert-success'>" . $_SESSION['status'] . "</h5>";
        unset($_SESSION['status']);
    }
    ?>
    <div class="row justify-content-center">
        <div class="col-md-6">

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
                                <input type="hidden" name="user_id" value="<?= $uid; ?>">
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
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h4>Enable/Disable Users Account</h4>
                </div>
                <div class="card-body">
                    <form action="code.php" method="POST">
                        <?php
                        if (isset($_GET['id'])) {
                            $uid = $_GET['id'];
                            try {
                                $user = $auth->getUser($uid);
                        ?>


                                <input type="hidden" name="ena_dis_user_id" value="<?= $uid; ?>">
                                <div class="input-group mb-3">
                                    <select name="select_enable_disable" id="" class="form-control">
                                        <option value="">Select</option>
                                        <option value="enable">Enable</option>
                                        <option value="disable">Disable</option>
                                    </select>
                                    <button type="submit" name="enable_disable_user_ac" class="input-group-text btn btn-primary">Submit</button>
                                </div>
                        <?php
                            } catch (\Kreait\Firebase\Exception\Auth\UserNotFound $e) {
                                echo $e->getMessage();
                            }
                        } else {
                            echo "No user id found";
                        }
                        ?>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <hr>
        </div>
        <div class="col-md-6">
            <div class="card-mt-4">
                <div class="card-header">
                    <h4>Change user's password</h4>
                </div>
                <div class="card-body">
                    <form action="code.php" method="POST">
                        <?php
                        if (isset($_GET['id'])) {
                            $uid = $_GET['id'];
                            try {
                                $user = $auth->getUser($uid);
                        ?>
                                <input type="hidden" name="change_pwd_user_id" value="<?= $uid; ?>">
                                <div class="formn-group mb-3">
                                    <label for="">New Password</label>
                                    <input type="text" name="new_password" required class="form-control">
                                </div>
                                <div class="formn-group mb-3">
                                    <label for="">Retype Password</label>
                                    <input type="text" name="retype_password" required class="form-control">
                                </div>
                                <div class="formn-group mb-3">
                                    <button type="submit" name="change_password_btn" class="btn btn_primary">Change Password</button>
                                </div>
                        <?php
                            } catch (\Kreait\Firebase\Exception\Auth\UserNotFound $e) {
                                echo $e->getMessage();
                            }
                        } else {
                            echo "No id found";
                        }
                        ?>

                    </form>
                </div>

            </div>
        </div>
        <div class="col-md-6">
            <div class="card mt-4">
                <div class="card-header">
                    <h4>Custom User Claims</h4>
                </div>
                <div class="card-body">
                    <form action="code.php" method="POST">
                        <?php
                        if (isset($_GET['id'])) {
                            $uid = $_GET['id'];
                        ?>
                            <input type="hidden" name="claims_user_id" value="<?= $uid; ?>">
                            <div class="form-group mb-3">
                                <select name="role_as" class="form-control" required>
                                    <option value="">Select roles</option>
                                    <option value="super_admin">Super Admin</option>
                                    <option value="admin">Admin</option>
                                    <option value="norole">Remove role</option>
                                </select>
                            </div>
                            <label for="">Currently,user role is:</label>
                            <h4 class="border bg-warning p-2">
                                <?php
                                $claims = $auth->getUser($uid)->customClaims;
                                if(isset($claims['admin'])==true)
                                {
                                    echo "Role:Admin";
                                }elseif(isset($claims['super_admin']) == true)
                                {
                                    echo "Role:Super Admin";
                                } elseif ($claims == null) 
                                {
                                    echo "Role:No Role";
                                }

                                ?>
                            </h4>
                            <div class="form-group mb-3">
                                <button type="submit" name="user_claims_btn" class="btn btn-primary">Submit</button>
                            </div>
                        <?php
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