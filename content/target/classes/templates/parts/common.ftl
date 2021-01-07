<#import "navbar.ftl" as nav>
<#macro page title>


    <!DOCTYPE html>
    <html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <base href="/"/>
        <title>FITLab${title}</title>

        <!-- Bootstrap core CSS-->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="assets/vendor/jquery/jquery.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">

        <link href="styles.css" rel="stylesheet">
    </head>

    <body>
    <@nav.navbar/>
    <div style="height:5%"></div>
    <#nested>

    <!-- Footer -->
    <footer style="height:15%">
        <div class="container-fluid h-100 pt-5">
            <div class="copyright-text">
                <p class="text-center">Copyright &copy; FITLab 2020</p>
            </div>
        </div>
    </footer>

    </body>

    </html>
</#macro>
