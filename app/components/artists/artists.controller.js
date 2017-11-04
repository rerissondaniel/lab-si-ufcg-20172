angular.module("labsi").controller("ArtistsCtrl", ["ArtistsService", function(artistsService){
	var self = this;

	self.artists = artistsService.getArtists();

	self.addArtist = function(artist){
		artistsService.add(artist);
		self.artists = artistsService.getArtists();
		_cleanArtistForm();
	};

	function _cleanArtistForm(){
        self.artist = {};
        //noinspection JSUnresolvedVariable
        self.artistForm.$setPristine();
	}

    self.isNameAvailable = function(name){
		var artistWithName = self.artists.find(function(artist){
			return name === artist.name;
		});

		return !artistWithName;
	};
}]);