const showUserOptions = (userIcon, profileOptions) =>{
   userIcon.addEventListener("click", function() {
        profileOptions.classList.toggle('show');
    }); 
    
    document.addEventListener('click', function (event) {
        if (!profileOptions.contains(event.target) && !userIcon.contains(event.target)) {
            profileOptions.classList.remove('show');
        }
    });
};

const showUserActions = (user__icon, hiddenActions) => {
    user__icon.addEventListener('click', function () {
        hiddenActions.classList.toggle('show');
    });
    
    document.addEventListener('click', function (event) {
        if (!hiddenActions.contains(event.target) && !user__icon.contains(event.target)) {
            hiddenActions.classList.remove('show');
        }
    });
};

export { showUserOptions, showUserActions };
  
  


