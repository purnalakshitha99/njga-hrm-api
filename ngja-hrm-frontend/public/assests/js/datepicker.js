(function() {
    "use strict";

    document.addEventListener('DOMContentLoaded', function () {
        var datePicker = document.getElementById('datepicker');

        flatpickr(datePicker, {
            dateFormat: "Y-m-d",
            disableMobile: true,
            // Add more options as needed
        });
        
        // Your additional code can go here if needed
    });
})();
