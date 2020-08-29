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
                <p class="subheading font-weight-regular">
                    <strong>Draftviewo</strong> provides quick analysis your project from zip archive
                </p>

                <p class="subheading font-weight-regular">
                    Quick analysis includes:
                </p>
                <tabel>
                    <li>size archive</li>
                    <li>type of files</li>
                    <li>quantity of files</li>
                    <li>quantity of folders</li>
                    <li>tree-structure of archive</li>
                </tabel>

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
    ul {
        list-style-type: disc;
    }
</style>
