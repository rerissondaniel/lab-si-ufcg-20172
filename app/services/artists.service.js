angular.module("labsi").service("ArtistsService", function(){
	var _artists = [];

	this.add = function(artist){
		_artists.push(artist);
	};

	this.getArtists = function (){
		return angular.copy(_artists);
	};
});