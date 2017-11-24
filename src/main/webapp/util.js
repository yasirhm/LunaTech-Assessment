/**
 * Created by Yasi on 11/21/2017.
 */
function validateInput() {
    if (document.form.code.value == "" && document.form.name.value == "") {
        alert("Please enter country name or country code.");
        document.form.code.focus();
        document.form.name.focus();
        return false;
    }else return true;
}

$(function changeElementPerPage() {
    var table = '#resultTable';
    $('#maxRows').on('change', function(){
        $('.pagination').html('');
        var trnum = 0;
        var maxRows = parseInt($(this).val());
        var totalRows = $(table+' tbody tr').length;
        $(table+' tr:gt(0)').each(function(){
            trnum++;
            if(trnum > maxRows){
                $(this).hide()
            }
            if(trnum <= maxRows){
                $(this).show()
            }
        });
        if(totalRows > maxRows){
            var pagenum = Math.ceil(totalRows/maxRows);
            for(var i=1;i<=pagenum;){
                $('.pagination').append('<li data-page="'+i+'">\<span>'+ i++ +'</span>\</li>').show()
            }
        }
        $('.pagination li:first-child').addClass('active');
        $('.pagination li').on('click',function(){
            var pagenum = $(this).attr('data-page');
            var trIndex = 0;
            $('.pagination li').removeClass('active');
            $(this).addClass('active');
            $(table+' tr:gt(0)').each(function(){
                trIndex++;
                if(trIndex > (maxRows*pagenum) || trIndex <= ((maxRows*pagenum)-maxRows)){
                    $(this).hide()
                }else{
                    $(this).show()
                }
            })
        })
    })
})

$(function(){
    $('table tr:eq(0)').prepend('<th>#</th>');
    var id = 0;
    $('table tr:gt(0)').each(function(){
        id++;
        $(this).prepend('<td>'+id+'</td>')
    })
})


