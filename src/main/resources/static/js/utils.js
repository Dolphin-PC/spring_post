class Util {
    constructor() {

    }

    getPagePerCnt() {
        return '5';
    }

    getCurrentPage() {
        return '1';
    }
}

class Page {
    constructor(props) {
        this.req = {
            number : 1,
            size : 10,
        };
        this.info = {};
        this.renderTarget = "";
        this.renderFn = "";
    }

    setData(res) {
        this.info = res;
    }

    render() {
        let html = "";
        let list = this.info['content'];

        html = list.map(this.renderFn);

        this.renderTarget.html(html);
    }

}

const util = new Util();
const page = new Page();
