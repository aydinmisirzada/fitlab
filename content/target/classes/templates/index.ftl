<#import "parts/common.ftl" as c>

<@c.page "">

    <div class="container-fluid p-0" style="height:50%">
        <div class="img-teaser h-100 float-left" style="width:40%">
            <img src="/images/FIT_people.jpeg" class="img-fluid h-100 w-100">
        </div>
        <div class="text-teaser h-100 float-left p-5" style="width:60%;">
            <div class="w-75">
                <h2>Welcome to FITLab!</h2>
                <p class="text-justify">Ambitioni dedisse scripsisse iudicaretur. Cras mattis iudicium purus sit amet
                    fermentum. Donec sed odio operae, eu vulputate felis rhoncus. Praeterea iter est quasdam res quas ex
                    communi. At nos hinc posthac, sitientis piros Afros. Petierunt uti sibi concilium totius Galliae in
                    diem certam indicere. Cras mattis iudicium purus sit amet fermentum.</p>
            </div>
        </div>
    </div>
    <div class="container mt-5">
        <div class="news-section">
            <div class="news-header">
                <h2>Latest at FIT</h2>
            </div>
            <div class="card-deck mt-4">
                <div class="card news-card">
                    <img src="https://fit.cvut.cz/zivot-na-fit/zpravy/2020/image-thumb__2024__NewsPreviewImage/2020-11-23-cena_msmt_koronavirus24.jpeg"
                         class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"><a href="https://fit.cvut.cz/cs/zivot-na-fit/aktualne/zpravy/15109-tri-studenti-fit-ziskali-cenu-ministra-skolstvi">Tři studenti FIT získali Cenu ministra školství</a></h5>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">23.11.2020</small>
                    </div>
                </div>
                <div class="card news-card">
                    <img src="https://fit.cvut.cz/zivot-na-fit/zpravy/2020/image-thumb__1989__NewsPreviewImage/2020-11-11-it_spy_2020.png"
                         class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"><a href="https://fit.cvut.cz/cs/zivot-na-fit/aktualne/zpravy/15061-absolvent-fit-se-probojoval-do-finale-souteze-it-spy-2020">Absolvent FIT se probojoval do finále soutěže IT SPY 2020</a></h5>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">11.11.2020</small>
                    </div>
                </div>
                <div class="card news-card">
                    <img src="https://fit.cvut.cz/zivot-na-fit/zpravy/2020/koronavirus/image-thumb__832__NewsPreviewImage/koronavirus.jpeg"
                         class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"><a href="https://fit.cvut.cz/cs/zivot-na-fit/aktualne/zpravy/10686-koronavirus-aktualne">Koronavirus – Aktuálně</a></h5>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">25.11.2020</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="discover-section mt-5">
            <div class="discover-header">
                <h2>Discover FITLab</h2>
            </div>
            <div class="pt-3 pb-3">
                <h4>Subjects at FIT</h4>
            </div>
            <div class="card-deck">
                <#if subjectSet?size gt 2>
                <#assign subjects = [subjectSet[0],subjectSet[1],subjectSet[2]]>
                <#list subjects as s>

                    <div class="card">
                        <div class="card-body">
                            <a href="subjects/${s.getCode()}"><h5 class="card-title">${s.getCode()}</h5></a>
                            <p class="card-text">${s.getName()}</p>
                        </div>
                    </div>
                </#list>
                </#if>
            </div>
            <a class="btn btn-primary mt-3" href="subjects" role="button">See all</a>
        </div>
    </div>
    <div class="container-fluid mt-5 pt-5 h-50 aboutus-section">
        <div class="container">
            <div class="aboutus-header">
                <h2>About FITLab</h2>
            </div>
            <div class="row mt-3">
                <div class="col">
                    <h4>For students, from students</h4>
                    <p class="text-justify">FITLab was designed in 2020 by a group of students as a semestral project
                        for BIE-SP course. Back in the day, students at FIT studying in English did not have any
                        collaboration platform, where they could find all the information they need for studies. On the
                        other hand, there was a platform called fitwiki, however it was only in Czech. Our team's
                        solution aims to facilitate studies at FIT by providing a tool to look up and share information,
                        be it about a particular subject, or homework, or even a teacher. Users can enjoy private
                        messaging tool to discuss important assignments.</p>
                </div>
                <div class="col offset-1">
                    <h4>Why FITLab?</h4>
                    <ul>
                        <li>Easy to use</li>
                        <li>Fully in English</li>
                        <li>Review a subject before enrolling</li>
                        <li>Find info on a specific teacher, and what students think of him</li>
                        <li>Help and get help from other students</li>
                    </ul>
                    <div class="joinus-btn w-50">
                        <a class="btn btn-primary btn-block mt-1" href="registration" role="button">Join us today</a>
                    </div>

                </div>

            </div>

        </div>

    </div>

    <script type = "text/javascript">

        $(function() {
            $.getJSON('https://fit-parser.herokuapp.com', function(json) {
                $('.news-card').each(function(i, obj) {
                    $(obj).find("a").text(json[i].title);
                    $(obj).find("a").attr("href",json[i].url)
                    $(obj).find("small").text(json[i].date);
                    $(obj).find("img").attr("src",json[i].img_url);
                });
            });
        });
    </script>


</@c.page>
