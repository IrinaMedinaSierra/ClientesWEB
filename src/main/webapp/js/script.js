/**
 * 
 */

(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
    
  })
 
const form = document.getElementById("form");
const form2 = document.getElementById("form2");
form.addEventListener(
  "focus",
  (event) => {
	document.getElementById("mensaje").style.display = "none";  },
  true
);

form2.addEventListener(
  "focus",
  (event) => {
	document.getElementById("mensaje2").style.display = "none";  },
  true
);

})()
