jQuery(document).ready(function() {

    var resultContainer = $('.result');

    $('.submit-button').on('click', function() {
        var input = $('#input').val();
        resultContainer.empty();
        resultContainer.append('<h1>Resultado</h1>');
        if(input !== "" && input !== null && input !== undefined) {
            $.ajax({
                url: '/jflex',
                data: {
                    input: input
                },
                method: 'GET',
                type: 'GET',
                success: function(results) {
                    if(results.length > 0) {
                        $.each(results, function(i, val) {
                            var colorRow = $('<div class="color-row grow"><h2>'+ val +'</h2>');
                            resultContainer.append(colorRow);
                        })
                    }
                }
            });
        } else {

        }
    })
});