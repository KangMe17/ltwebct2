<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Register</title>
</head>
<body>
<main class="container">
    <header class="row">
        <div class="col">
            <div class="alert alert-success col">
                <h1>Register</h1>
            </div>
        </div>
    </header>
    <section class="row">
        <div class="col-7">
            <div class="row">
                <div class="col">
                    <form action="register" method="post">
                        <div class="form-group">
                            <label for="username">User name:</label>
                            <input type="text" id="username" name="username" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Gender:</label>
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" id="genderM" name="gender" value="Male"/>
                                <label for="genderM">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" id="genderF" name="gender" value="Female"/>
                                <label for="genderF">Female</label>
                            </div>
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="checkbox" class="form-check-input" id="married" name="married" value="Yes"/>
                            <label for="married">Married</label>
                        </div>
                        <div class="form-group">
                            <label for="nation">Nation:</label>
                            <select name="nation" id="nation" class="form-control">
                                <option value="Vietnam">Vietnam</option>
                                <option value="America">America</option>
                                <option value="Korea">Korea</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="note">Note:</label>
                            <textarea name="note" id="note" cols="30" rows="10" class="form-control"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Favorite:</label>
                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input" id="favorite1" name="favorite" value="Sport"/>
                                <label for="favorite1">Sport</label>
                                <input type="checkbox" class="form-check-input" id="favorite2" name="favorite" value="Music"/>
                                <label for="favorite2">Music</label>
                                <input type="checkbox" class="form-check-input" id="favorite3" name="favorite" value="Technology"/>
                                <label for="favorite3">Technology</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-5">
            <h1>Information has been registered</h1>
            <ul>
                <li>User name: ${username}</li>
                <li>Password: ${password}</li>
                <li>Gender: ${gender}</li>
                <li>Married: ${married}</li>
                <li>Nation: ${nation}</li>
                <li>Favorite: ${favorite}</li>
                <li>Note: ${note}</li>
            </ul>
        </div>
    </section>
</main>
</body>
</html>
