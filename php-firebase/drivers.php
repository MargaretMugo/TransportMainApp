<?php
include('includes/header.php');
?>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h4>
                        Add Driver
                        <!--<a href="drivers.php" class="btn btn-primary float-end">Back</a>-->
                    </h4>
                </div>
                <div class="card-body">
                    <form action="code.php" method="POST">

                        <div class="form-group mb-3">
                            <label for="">Full Name</label>
                            <input type="text" name="fullName" class="form-control">
                        </div>

                        <div class="form-group mb-3">
                            <label for="">Email</label>
                            <input type="email" name="email" class="form-control">
                        </div>
                        <div class="form-group mb-3">
                            <label for="">Phone Number</label>
                            <input type="number" name="phone" class="form-control">
                        </div>
                        <div class="form-group mb-3">
                            <button type="submit" name="save_user" class="btn btn-primary">Save Driver</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<?php
include('includes/footer.php');
?>