<template>
    <v-container class="logon" :style="{'max-width':component_max_width}">
        <h5 class="headline">Login</h5>
        <form>
            <v-text-field
                    v-model="logino"
                    :error-messages="loginoErrors"
                    label="Login"
                    required
                    @input="$v.logino.$touch()"
                    @blur="$v.logino.$touch()">
            </v-text-field>

            <v-text-field
                    v-model="passwordo"
                    type="password"
                    :error-messages="passwordoErrors"
                    label="Password"
                    required
                    @input="$v.passwordo.$touch()"
                    @blur="$v.passwordo.$touch()">
            </v-text-field>
            <br>
            <v-btn color="add2" @click="submit" v-on:click="login(logino,passwordo)">Save</v-btn>
        </form>
    </v-container>
</template>

<script>
    import request from '../request'
    import constant from '../constant'
    import App from '../App'
    import ProgressBar from './ProgressBar'

    export default {
        data: () => ({
            loginoErrors: null,
            passwordoErrors: null,
            component_max_width: constant.data().COMMON_SIZING.component_max_width + 'px',
        }),
        methods: {
            login(logino, passwordo) {
                let self = this;
                //TODO ProgressBar.data().active = true;

                request.methods.login(logino, passwordo)
                    .then(function (result) {
                        self.clearError();
                        if (result.status === 'OK') {
                            App.props.user = result.data;
                            self.$router.push('/main');
                        } else if (constant.methods.responseErrorValidCode(result)) {
                            let error = constant.methods.responseErrorValidMessage(result);
                            if (error.includes('Login')) {
                                self.loginoErrors = error;
                            }
                            if (error.includes('Pass')) {
                                self.passwordoErrors = error;
                            }
                        } else {
                            if (result.message.includes('Login')) {
                                self.loginoErrors = result.message;
                            }
                            if (result.message.includes('Pass')) {
                                self.passwordoErrors = result.message;
                            }
                        }
                    });
            },
            clearError() {
                let self = this;
                self.loginoErrors = null;
                self.passwordoErrors = null;
            },
        },
    }
</script>