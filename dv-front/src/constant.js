const app_name = "Draftviewo";

const palette = {
    main: '#010101',
    add1: '#acdbdf',
    add2: '#acdbdf',
    back: '#f0ece2'
};

const common_sizing = {
    component_max_width: 500,
};


const API_CALL = {
    login: '/api/users/user',
    signup: '/api/users',
    contact: '/api/contact',
};

const SERV_CODE = {
    error_valid: 400
};

export default ({
    data: () => ({
        APP_NAME: app_name,
        APP_SIZING: common_sizing,
        API_CALL: API_CALL,
        API_CODE: SERV_CODE,
        COMMON_SIZING: common_sizing,
        COLOR: palette,
    }),
    methods: {
        responseErrorValidCode(response) {
            return (response.status === SERV_CODE.error_valid);
        },
        responseErrorValidMessage(response) {
            return response.errors[0].defaultMessage;
        },
        /*example(request) {
            return response;
        },*/
    }
});
