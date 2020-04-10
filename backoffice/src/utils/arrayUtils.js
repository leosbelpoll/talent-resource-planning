export const isPresent = (item, array) => array.indexOf(item) !== -1;

export const isNotPresent = (item, array) => !isPresent(item, array);

export const pushIsNotPresent = (item, array) => {
    if (isNotPresent(item, array)) {
        return [...array, item];
    }

    return array;
};

export const shiftIsNotPresent = (item, array) => {
    if (isNotPresent(item, array)) {
        return [item, ...array];
    }

    return array;
};
