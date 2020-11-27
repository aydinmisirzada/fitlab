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

        <link href="styles.css" rel="stylesheet">
    </head>

    <body>
    <@nav.navbar/>
    <div style="height:10%"></div>
    <#nested>

    <!-- Footer -->
    <footer class="h-25">
        <div class="container-fluid h-100 pt-5">
            <div class="copyright-text">
                <p class="text-center">Copyright &copy; FITLab 2020</p>
            </div>
        </div>
    </footer>

    </body>

    </html>
</#macro>
