<template>
    <v-container class="contacton" :style="{'max-width':component_max_width}">
        <h5 class="headline">Contact us</h5>
        <form>
            <v-text-field
                    v-model="namo"
                    :error-messages="namoErrors"
                    label="Name"
                    required
                    @input="$v.namo.$touch()"
                    @blur="$v.namo.$touch()">
            </v-text-field>

            <v-text-field
                    v-model="emailo"
                    :error-messages="emailoErrors"
                    label="Email"
                    required
                    @input="$v.emailo.$touch()"
                    @blur="$v.emailo.$touch()">
            </v-text-field>

            <v-textarea
                    v-model="messago"
                    :error-messages="messagoErrors"
                    label="Message"
                    required
                    @input="$v.messago.$touch()"
                    @blur="$v.messago.$touch()">
            </v-textarea>
            <br>
            <v-btn color="add2" @click="submit" v-on:click="send(namo,emailo,messago)">Send</v-btn>
        </form>
    </v-container>
</template>

<script>
    import request from '../request'
    import constant from '../constant'
    import ProgressBar from './ProgressBar'

    export default {
        data: () => ({
            namoErrors: null,
            emailoErrors: null,
            messagoErrors: null,
            component_max_width: constant.data().COMMON_SIZING.component_max_width + 'px',
        }),
        methods: {
            send(namo, emailo, messago) {
                let self = this;
                ProgressBar.data().active = true;

                request.methods.send(namo, emailo, messago)
                    .then(function (result) {
                        self.clearError();
                        if (result.status === 'OK') {
                            self.$router.push('/');
                        } else {
                            if (constant.methods.responseErrorValidCode(result)) {
                                let error = constant.methods.responseErrorValidMessage(result);
                                if (error.includes('Name')) {
                                    self.namoErrors = error;
                                }
                                if (error.includes('Email')) {
                                    self.emailoErrors = error;
                                }
                                if (error.includes('Message')) {
                                    self.messagoErrors = error;
                                }
                            }
                        }
                    });
            },
            clearError() {
                let self = this;
                self.namoErrors = null;
                self.emailoErrors = null;
                self.messagoErrors = null;
            },
        },
    }
</script>
