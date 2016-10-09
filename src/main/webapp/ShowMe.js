/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {

var $Personsul = $('#Personsul');
$.ajax({
type:'GET',
        url:'http://localhost:8084/CAs2/api/Person/Complete/',
        success: function(Persons){
        $.each(Persons, function(i, person){
         $Personsul.append('<li>firstName: '+person.firstName+', lastName: '+person.lastName+' id: '+person.id+'</li>');   
        });
        }


});
});
