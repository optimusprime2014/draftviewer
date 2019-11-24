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
        <h1>Existed drafts</h1>
        <v-data-table
                :headers="headers"
                :items="desserts"
                class="elevation-1">
            <template v-slot:items="props">
                <td>
                    <v-btn v-on:click="goToDraft(props.item.name)" color="add2">{{ props.item.name }}</v-btn>
                </td>
                <td class="text-xs-right">{{ props.item.role }}</td>
                <td class="text-xs-right">{{ props.item.file }}</td>
                <td class="text-xs-right">{{ props.item.folder }}</td>
                <td class="text-xs-right">{{ props.item.deep }}</td>
                <td class="text-xs-right">{{ props.item.date }}</td>
                <td class="text-xs-right">{{ props.item.comment }}</td>
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
                {text: 'Role', align: 'center', value: 'role'},
                {text: 'Files', align: 'center', value: 'file'},
                {text: 'Folders', align: 'center', value: 'folder'},
                {text: 'Deep', align: 'center', value: 'deep'},
                {text: 'Upload date', align: 'center', value: 'date'},
                {text: 'Comments', align: 'right', value: 'comment'}
            ],
            desserts: [
                {
                    name: 'Frozen Yogurt',
                    role: 'Owner',
                    file: 159,
                    folder: 6.0,
                    deep: 24,
                    date: 4.0,
                    comment: '1%'
                },
                {
                    name: 'Ice cream sandwich',
                    role: 'Invited from [FRIEND]',
                    file: 237,
                    folder: 9.0,
                    deep: 37,
                    date: 4.3,
                    comment: '1%'
                },
                {
                    name: 'Eclair',
                    role: 'Owner',
                    file: 262,
                    folder: 16.0,
                    deep: 23,
                    date: 6.0,
                    comment: '7%'
                },
                {
                    name: 'Cupcake',
                    role: 'Owner',
                    file: 305,
                    folder: 3.7,
                    deep: 67,
                    date: 4.3,
                    comment: '8%'
                },
                {
                    name: 'Gingerbread',
                    role: 'Owner',
                    file: 356,
                    folder: 16.0,
                    deep: 49,
                    date: 3.9,
                    comment: '16%'
                },
                {
                    name: 'Jelly bean',
                    role: 'Owner',
                    file: 375,
                    folder: 0.0,
                    deep: 94,
                    date: 0.0,
                    comment: '0%'
                },
                {
                    name: 'Lollipop',
                    role: 'Owner',
                    file: 392,
                    folder: 0.2,
                    deep: 98,
                    date: 0,
                    comment: '2%'
                },
                {
                    name: 'Honeycomb',
                    role: 'Owner',
                    file: 408,
                    folder: 3.2,
                    deep: 87,
                    date: 6.5,
                    comment: '45%'
                },
                {
                    name: 'Donut',
                    role: 'Owner',
                    file: 452,
                    folder: 25.0,
                    deep: 51,
                    date: 4.9,
                    comment: '22%'
                },
                {
                    name: 'KitKat',
                    role: 'Owner',
                    file: 518,
                    folder: 26.0,
                    deep: 65,
                    date: 7,
                    comment: '6%'
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
