<template>
    <v-container class="signon" :style="{'max-width':component_max_width}">
        <h5 class="headline">Sign up</h5>
        <form>
            <v-text-field
                    v-model="logino"
                    :error-messages="loginoErrors"
                    label="Login"
                    required
                    @input="$v.logino.$touch()"
                    @blur="$v.logino.$touch()" >
            </v-text-field>

            <v-text-field
                    v-model="emailo"
                    :error-messages="emailoErrors"
                    label="Email"
                    required
                    @input="$v.emailo.$touch()"
                    @blur="$v.emailo.$touch()" >
            </v-text-field>

            <v-text-field
                    v-model="passwordo"
                    type="password"
                    :error-messages="passwordoErrors"
                    label="Password"
                    required
                    @input="$v.passwordo.$touch()"
                    @blur="$v.passwordo.$touch()" >
            </v-text-field>

            <v-text-field
                    v-model="confirmPasswordo"
                    type="password"
                    :error-messages="confirmPasswordoErrors"
                    label="Confirm password"
                    required
                    @input="$v.confirmPasswordo.$touch()"
                    @blur="$v.confirmPasswordo.$touch()" >
            </v-text-field>
            <br>
            <v-btn color="add2" @click="submit" v-on:click="signup(logino, passwordo, confirmPasswordo, emailo)">Save</v-btn>
        </form>
    </v-container>
</template>

<script>
    import request from '../request'
    import constant from '../constant'

    export default {
        data: () => ({
            loginoErrors: null,
            emailoErrors: null,
            confirmPasswordoErrors: null,

            component_max_width: constant.data().COMMON_SIZING.component_max_width + 'px',
        }),
        methods: {
            signup(logino, passwordo, confirmPasswordo, emailo) {
                let self = this;

                request.methods.signup(logino, passwordo, confirmPasswordo, emailo)
                    .then(function (result) {
                        if (result.status === 'OK') {
                            alert(result.data);
                            //TODO redirect to normal page
                            //TODO check status: 400
                        } else {
                            self.clearErrors();
                            if (result.message.includes('Login')) {
                                self.loginoErrors = result.message;
                            }
                            if (result.message.includes('Email')) {
                                self.emailoErrors = result.message;
                            }
                            if (result.message.includes('Confirm')) {
                                self.confirmPasswordoErrors = result.message;
                            }
                        }
                    });
            },
            clearErrors() {
                this.loginoErrors = null;
                this.emailoErrors = null;
                this.confirmPasswordoErrors = null;
            }
        },
    }
</script>
