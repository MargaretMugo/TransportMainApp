<?php
session_start();
include('includes/header.php');
?>

<div class="container">
    <div class="row">
        <div class="col-md-6 mb-3">
            <div class="card">
                <div class="card-body">
                    <h5>Total Number of Records</h5>
                    <?php
                    include('dbcon.php');
                    $ref_table = 'Users';
                    $total_count = $database->getReference($ref_table)->numChildren();
                    echo $total_count;
                    ?>
                </div>
            </div>
        </div>
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
                        Admin Panel
                        <a href="add-user.php" class="btn btn-primary float-end">Add Users</a>
                    </h4>
                </div>
                <div class="card-body">
                    <table class="table table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Sl No</th>
                                <th>Full Name</th>
                                <th>Age</th>
                                <th>Email</th>
                                <th>Phone Number</th>
                                <th>Edit</th>
                                <th>Disable</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            include('dbcon.php');

                            $ref_table = 'Users';
                            $fetchdata = $database->getReference($ref_table)->getValue();
                            if ($fetchdata > 0) {
                                $i = 1;
                                foreach ($fetchdata as $key => $row) {
                            ?>
                                    <tr>
                                        <td><?= $i++; ?></td>
                                        <td><?= $row['fullName'] ?></td>
                                        <td><?= $row['age'] ?></td>
                                        <td><?= $row['email'] ?></td>
                                        <td><?= $row['phone'] ?></td>
                                        <td>
                                            <a href="edit-user.php?id=<?= $key; ?>" class="btn btn-primary btn-sm">Edit</a>
                                        </td>
                                        <td>
                                            <!--<a href="disable-user.php" class="btn btn-danger btn-sm">Disable</a>-->
                                            <form action="code.php" method="POST">
                                                <button type="submit" name="disable_btn" value="<?= $key ?>" class="btn btn-danger btn-sm">Disable</button>

                                            </form>
                                        </td>
                                    </tr>
                                <?php
                                }
                            } else {
                                ?>
                                <tr>
                                    <td colspan="7">No Record Found</td>
                                </tr>
                            <?php
                            }
                            ?>

                        </tbody>
                    </table>


                </div>
            </div>
        </div>
    </div>
</div>

<?php
include('includes/footer.php');
?>