$(function() {
    
    // set current menu item to active
    activateNavItem("playlist");
    
    // setup form validation
    $('#playlistForm').validate({
        rules: {
            requester: {
                required: true
//                email: true
            },
            artist: "required", 
            track: "required",
            why: {
                required: false,
                maxlength: 500
            }
        },
//        messages: {
//            requester: {
//                required: " Requester cannot be empty"
////                email: "Requester must be a valid email address"
//            }, 
//            artist: " Artist cannot be empty",
//            track: " Track cannot be empty",
//            why: {
//                maxlength: jQuery.format("Why must be less than {0} characters")    
//            }
//        },
        errorElement: "span"
    });
    
});