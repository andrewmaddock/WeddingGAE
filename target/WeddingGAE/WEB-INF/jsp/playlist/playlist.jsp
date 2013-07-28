<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en" ng-app>

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section style="min-height: 820px !important;" class="bottomrow">
            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/resources/images/playlist/wedding-playlist-title.jpg'/>" alt="wedding-playlist-title" width="129" height="44">

                <div class="formo" ng-controller="SongDisplay">
                    <div class="form-header2"><p>Please Request Songs For The After Party</p></div>
                    <form class="form" method="post" action="http://www.overtongraphics.com/wedding/php/artist.php">
                        <div class="heado"></div>
                        <div class="divider"></div>

                        <input class="fname" type="text" name="name" placeholder="  Your Name:" required>
                        <div class="divider2"></div>

                        <ul class="songs">

                            <li ng-show="!songs.length"><small>Please add a song.</small></li>

                            <li class="inputartist" ng-repeat="song in songs">
                                <input class="artist" id="song{{$index + 1}}" name="artist[]" type="text"  placeholder="  Artist:" required><br />
                                <input class="song" id="song{{$index + 1}}" name="song[]" type="text" placeholder="  Track:" required>
                                <p><a class="deleteb" href="" ng-click="removeSong(song)">Delete</a></p>
                            </li>
                        </ul>

                        <p><a class="addone" href="" ng-click="addSong()">Add Another?</a> </p>

                        <div class="divider"></div>
                        <input class="subt" type="submit" name="submit" value="SUBMIT" />
                    </form>
                    <div class="form-footer"></div>
                </div>


            </div>
        </section>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navPlaylist");</script>
    <script type="text/javascript">

        function SongDisplay($scope) {

            $scope.songs = [
                {artist: 'Artist:', track: 'Track:'}
            ];

            $scope.addSong = function () {
                this.songs.push({artist: 'Artist:', track: 'Track:'});
            };

            $scope.removeSong = function (songToRemove) {
                var index = this.songs.indexOf(songToRemove);
                this.songs.splice(index, 1);
            };

        }

    </script>

</body>
</html>