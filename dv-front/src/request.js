import axios from 'axios'
import sha1 from 'js-sha1'
import constant from './constant'

export default ({
    methods: {
        login: function (logino, passwordo) {
            let crypted_password = sha1(passwordo);
            return new Promise((resolve) => {
                axios.post(
                    constant.data().API_CALL.login,
                    {
                        login: logino,
                        pass: crypted_password
                    }
                )
                    .then(response => resolve(response.data))
                    .catch(error => resolve(error.response.data));
            });
        },
        signup: function (logino, passwordo, confirmPasswordo, emailo) {
            let crypted_password = sha1(passwordo);
            let crypted_confirmPassword = sha1(confirmPasswordo);
            return new Promise((resolve) => {
                axios.post(
                    constant.data().API_CALL.signup,
                    {
                        login: logino,
                        pass: crypted_password,
                        confirmPass: crypted_confirmPassword,
                        email: emailo
                    }
                )
                    .then(response => resolve(response.data))
                    .catch(error => resolve(error.response.data));
            });
        },
        send: function (namo, emailo, messago) {

            return new Promise((resolve) => {
                axios.post(
                    constant.data().API_CALL.contact,
                    {
                        name: namo,
                        email: emailo,
                        message: messago
                    }
                )
                    .then(response => resolve(response.data))
                    .catch(error => resolve(error.response.data));
            });
        },
    }
});