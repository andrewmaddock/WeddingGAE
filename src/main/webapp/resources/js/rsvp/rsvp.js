$(function() {
    
    // set current menu item to active
    activateNavItem("rsvp");
    
    // show/hide attending group of fields
    $('input:radio[name="attending"]').change(function() {
        $('#attendingGroup').toggle();   
    }); 
    
    // setup form validation
    $('#rsvpForm').validate({
        rules: {
            names: "required",
            attending: "required",
            adults: {
                required: true,
                range: [0, 4]
            },
            children: {
                required: true,
                range: [0, 4]
            },
//            transport: "required",
            messages: {
                required: true,
                maxlength: 500
            }
        },
        messages: {
            names: "Names cannot be empty",
            attending: " Attending must be entered",
            adults: {
                required: " Adults must be entered",
                range: jQuery.format(" Adults must be between {0} and {1}")
            },
            children: {
                required: " Children must be entered",
                range: jQuery.format(" Children must be between {0} and {1}")
            },
//            transport: " Transport must be entered",
            messages: {
                maxlength: jQuery.format(" Messages must be less than {0} characters")
            }
        },
        errorElement: "span",
        submitHandler: function(form) {
            
            // Clear attending fields if not attending
            if($('#attendingFalse').is(':checked')) {
                $('#adults, #children').val(0);        
                $('#transport').prop('checked', false);     
                $('#messages').val("");        
            }
            
            form.submit();
            
        }  
    });
    
});