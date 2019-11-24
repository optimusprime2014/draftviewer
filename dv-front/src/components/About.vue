<template>
    <v-container>
        <v-layout text-xs-center wrap>
            <v-flex xs12>
                <v-img
                        :src="require('../assets/logo.png')"
                        class="my-3"
                        contain
                        height="100"/>
            </v-flex>

            <v-flex mb-4>
                <h1 class="display-2 font-weight-bold mb-3">
                    Welcome to -> DREAFTVIEWO
                </h1>
                <p class="subheading font-weight-regular">
                    Starry flounder catalufa. Frogmouth catfish ballan wrasse, footballfish longfin dragonfish.
                    Ridgehead electric ray orbicular batfish; ghost carp, marblefish Modoc sucker pelican eel algae
                    eater tigerperch hairtail. Pacific salmon silver hake Sundaland.
                </p>
                <p class="subheading font-weight-regular">
                    Wrymouth, "river loach rockling featherfin knifefish Cherubfish; collared dogfish tetra clownfish
                    bigscale; eagle ray sea raven sturgeon." Blue whiting northern Stargazer Molly Miller butterfly ray;
                    Molly Miller kappy southern Dolly Varden. Finback cat shark ribbon sawtail fish whitetip reef shark
                    banjo catfish longjaw mudsucker flagfin flagtail Oriental loach whiting pelican eel.
                </p>
                <p class="subheading font-weight-regular">
                    Panga pikehead man-of-war fish round whitefish fathead sculpin kingfish torpedo eagle ray sea bream!
                    Gizzard shad antenna codlet temperate bass South American Lungfish; tadpole fish manefish eulachon!
                </p>

            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import ProgressBar from './ProgressBar'

    export default {
        data: () => ({
            ecosystem: [
                {
                    text: 'vuetify-loader',
                    href: 'https://github.com/vuetifyjs/vuetify-loader'
                },
                {
                    text: 'github',
                    href: 'https://github.com/vuetifyjs/vuetify'
                },
                {
                    text: 'awesome-vuetify',
                    href: 'https://github.com/vuetifyjs/awesome-vuetify'
                }
            ]
        })
    }
</script>

<style>

</style>
