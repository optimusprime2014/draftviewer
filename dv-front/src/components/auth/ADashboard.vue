<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-container class="dasho" :style="{'max-width':component_max_width_X15}">
        <h1>Upload draft</h1>
        <v-layout align-start justigy-center row fill-height>
            <v-text-field
                    v-model="fileo"
                    type="file"
                    :error-messages="fileoErrors"
                    label="Upload draft"
                    required
                    @input="$v.fileo.$touch()"
                    @blur="$v.fileo.$touch()">
            </v-text-field>
            <v-btn color="add2" @click="submit">View</v-btn>
        </v-layout>
        <br>
        <h1>Exist drafts</h1>
        <v-data-table
                :headers="headers"
                :items="desserts"
                class="elevation-1">
            <template v-slot:items="props">
                <td>
                    <v-btn v-on:click="goToDraft(props.item.name)" color="add2">{{ props.item.name }}</v-btn>
                </td>
                <td class="text-xs-right">{{ props.item.size }}</td>
                <td class="text-xs-right">{{ props.item.fileTypes }}</td>
                <td class="text-xs-right">{{ props.item.files }}</td>
                <td class="text-xs-right">{{ props.item.folders }}</td>
                <td class="text-xs-right">{{ props.item.uploadDate }}</td>
            </template>
        </v-data-table>
    </v-container>
</template>

<script>
    import constant from '../../constant'

    export default {
        data: () => ({
            component_max_width: constant.data().COMMON_SIZING.component_max_width + 'px',
            component_max_width_X15: (constant.data().COMMON_SIZING.component_max_width * 2.5) + 'px',
            headers: [
                {
                    text: 'Draft name',
                    /*align: 'left',
                    sortable: false,*/
                    value: 'name'
                },
                {text: 'Size', align: 'center', value: 'size'},
                {text: 'File types', align: 'center', value: 'fileTypes'},
                {text: 'Files', align: 'center', value: 'files'},
                {text: 'Folders', align: 'center', value: 'folders'},
                {text: 'Upload date', align: 'center', value: 'uploadDate'},
            ],
            desserts: [
                {
                    name: 'Frozen Yogurt',
                    size: 159,
                    fileTypes: 'url show modal chart',
                    files: 24,
                    folders: 4,
                    uploadDate: '2020-02-02',
                },
                {
                    name: 'Ice cream sandwich',
                    size: 237,
                    fileTypes: 'url show modal chart',
                    files: 37,
                    folders: 4,
                    uploadDate: '2020-02-02'
                }
            ]
        }),
        methods: {
            goToDraft(id) {
                this.$router.push('/main/draft');
            },
        },
    }
</script>
