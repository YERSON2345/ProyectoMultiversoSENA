

const btn = document.getElementById('button');

document.getElementById('Form')
 .addEventListener('submit', function(event) {
   event.preventDefault();

   btn.value = 'Sending...';

   const serviceID = 'default_service';
   const templateID = 'template_n1rjt2t';

   emailjs.sendForm(serviceID, templateID, this)
    .then(() => {
      btn.value = 'Send Email';
      alert('Se ha enviado un correo de notificación')
      location.href="usuario?condicion=index"
    }, (err) => {
      btn.value = 'Send Email';
      alert(JSON.stringify(err));
    });
});