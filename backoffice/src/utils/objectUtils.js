import { isNotPresent } from "./arrayUtils";

export const getKeys = object => {
    const keys = [];
    for (const key in object) {
        if (object.hasOwnProperty(key)) {
            keys.push(key);
        }
    }

    return keys;
};

export const getPrimitiveKeys = object => {
    const keys = [];
    for (const key in object) {
        if (object.hasOwnProperty(key) && ["string", "number", "boolean"].includes(typeof object[key]) ) {
            keys.push(key);
        }
    }

    return keys;
};

export const getUniqueKeys = object => {
    const keys = [];
    for (const key in object) {
        if (object.hasOwnProperty(key) && isNotPresent(key, keys)) {
            keys.push(key);
        }
    }

    return keys;
};

export const getUniquePrimitiveKeys = object => {
    const keys = [];
    for (const key in object) {
        if (object.hasOwnProperty(key) && isNotPresent(key, keys) && ["string", "number", "boolean"].includes(typeof object[key]) ) {
            keys.push(key);
        }
    }

    return keys;
};
