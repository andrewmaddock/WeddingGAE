$(function() {
    
    // set current menu item to active
    activateNavItem("playlist");
    
    // setup form validation
    $('#playlistForm').validate({
        rules: {
            requester: "required",
            artist: "required", 
            track: "required",
            why: {
                required: false,
                maxlength: 500
            }
        },
//        messages: {
//            required: " Requester cannot be empty",
//            artist: " Artist cannot be empty",
//            track: " Track cannot be empty",
//            why: {
//                maxlength: jQuery.format(" Why must be less than {0} characters")    
//            }
//        },
        errorElement: "span"
    });
    
});